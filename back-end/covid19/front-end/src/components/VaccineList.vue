<template>
	<v-simple-table>
		<template v-slot:default>
			<thead>
				<tr>
					<th class="text-left">
						회원명
					</th>
					<th class="text-left">
						백신종류
					</th>
					<th class="text-left">
						상태
					</th>
					<th class="text-left">
						날짜
					</th>
				</tr>
			</thead>
			<tbody>
				<tr v-for="item in items" :key="item.name">
					<td>{{ item.userName }}</td>
					<td>{{ item.orderName }}</td>

					<td>{{ item.orderStatus }}</td>
					<td>{{ item.orderDate }}</td>
				</tr>
			</tbody>
		</template>
	</v-simple-table>
</template>
<script>
import { fetchOrders } from '@/api/index';
export default {
	data() {
		return {
			items: [],
		};
	},
	async mounted() {
		const { data } = await fetchOrders();
		console.log(data);
		this.items = data;
	},
};
</script>
